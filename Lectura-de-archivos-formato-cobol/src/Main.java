import domain.Formato;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> listaFinal = new ArrayList<>();
        File cabeceras = new File("src/Cabeceras.txt");
        File datos = new File("src/Datos.txt");
        List<Formato> lista = new ArrayList<>();
        int contador = 0;
        char[] buffer;

        if (cabeceras.exists() && datos.exists()) {
            try {
                BufferedReader brCabeceras = new BufferedReader(new java.io.FileReader(cabeceras));
                BufferedReader brDatos = new BufferedReader(new java.io.FileReader(datos));
                while (brCabeceras.ready()) {
                    String cabecera = brCabeceras.readLine();
                    Integer tamaño = Integer.valueOf(cabecera.substring(cabecera.indexOf("(") + 1, cabecera.indexOf(")")));

                    if (cabecera.charAt(0) == 'X') {
                        lista.add(new Formato("String", tamaño));
                    } else if (cabecera.charAt(cabecera.length() - 1) == '9' && cabecera.charAt(0) == '9') {
                        int decimales = cabecera.length() - cabecera.indexOf(")");
                        int tamañoTotal = tamaño + decimales;
                        lista.add(new Formato("float", tamañoTotal));
                    } else if (cabecera.charAt(0) == '9') {
                        lista.add(new Formato("int", tamaño));
                    }
                }

                while (brDatos.ready()) {
                    buffer = new char[getSize(lista)];
                    int charsRead = brDatos.read(buffer, 0, getSize(lista));
                    List<String> listaAux = new ArrayList<>();
                    for (Formato f : lista) {
                        String dato = new String(buffer, contador, f.getTamaño());
                        contador += f.getTamaño();
                        listaAux.add(dato);
                    }
                    listaFinal.add(listaAux);
                    contador = 0;
                }
                System.out.println(listaFinal);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No se encontraron los archivos");
        }
    }

    private static int getSize(List<Formato> lista) {
        int size = 0;
        for (Formato f : lista) {
            size += f.getTamaño();
        }
        return size;
    }

}