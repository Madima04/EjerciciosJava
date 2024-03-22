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
        List<String[]> lista = new ArrayList<>();
        int contador = 0;


        if (cabeceras.exists() && datos.exists()) {
            try {
                BufferedReader brCabeceras = new BufferedReader(new java.io.FileReader(cabeceras));
                BufferedReader brDatos = new BufferedReader(new java.io.FileReader(datos));
                while (brCabeceras.ready()) {
                    String cabecera = brCabeceras.readLine();
                    Integer tamaño = Integer.valueOf(cabecera.substring(cabecera.indexOf("(") + 1, cabecera.indexOf(")")));
                    ;
                    if (cabecera.charAt(0) == 'X') {
                        lista.add(new String[]{"String", tamaño.toString()});
                    } else if (cabecera.charAt(cabecera.length() - 1) == '9' && cabecera.charAt(0) == '9') {
                        Integer decimales = cabecera.length() - cabecera.indexOf(")");
                        String tamañoTotal = String.valueOf(tamaño + decimales);
                        lista.add(new String[]{"float", tamañoTotal});
                    } else if (cabecera.charAt(0) == '9') {
                        lista.add(new String[]{"int", tamaño.toString()});
                    }
                }

                while (brDatos.ready()) {
                    String dato = brDatos.readLine();
                    contador = 0;
                    List<String> listaDatos = new ArrayList<>();
                    for (String[] strings : lista) {
                        String tipo = strings[0];
                        String tamaño = strings[1];
                        if (tipo.equals("String")) {
                            listaDatos.add(dato.substring(contador, contador + Integer.parseInt(tamaño)));
                            contador += Integer.parseInt(tamaño);
                        } else if (tipo.equals("int")) {
                            listaDatos.add(dato.substring(contador, contador + Integer.parseInt(tamaño)));
                            contador += Integer.parseInt(tamaño);
                        } else if (tipo.equals("float")) {
                            listaDatos.add(dato.substring(contador, contador + Integer.parseInt(tamaño)));
                            contador += Integer.parseInt(tamaño);
                        }
                    }
                    System.out.println(listaDatos);
                    listaFinal.add(listaDatos);
                }
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
}