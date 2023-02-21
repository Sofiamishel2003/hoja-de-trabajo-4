
//
//
//  @ Project : hoja de trabajo 2
//  @ File Name : controlador_postfix.java
//  @ Date : 31/01/2023
//  @ Author : Sofía Velásquez, Joaquín Campos, Julio García Salas
//
//

import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import java.util.ArrayList;
public class main_calculadora_postfix {

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList<String> lineas = new ArrayList<String>();
        String operacion="1 2 + 4 * 3 +";
        System.out.println(operacion);
        //Lectura de archivo
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el path");
        String path = in.nextLine();
        File file = new File(path);
        try {
            Scanner obj = new Scanner(file);
            while (obj.hasNextLine()){
                String linea=obj.nextLine();
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=1;
        for (String str : lineas)
        {
            String[] line = str.split(" ");
            System.out.println(i+". Operacion postfix: "+str);
            System.out.println("    -El resultado es : "+calacular(line));
            i=i+1;
        }
        //  System.out.println(lector.read(nombre_archivo));
    }

    /**
     * @param lista se ingresa una lista con los digitos para que se puedan hacer las operaciones
     * @return int
     */
    public static int calacular (String[] lista)
    {
        stack_<Integer> operandos= new stack_<Integer>();
        PostfixCalculator computadorsica = new PostfixCalculator();
        for(String i : lista)
        {
            if (i.trim().equals(""))
            {
                continue;
            }
            switch (i)
            {
                case "+":
                case "-":
                case "*":
                case "/":
                    int a=operandos.pull();
                    int b=operandos.pull();
                    int ans=0;
                    switch (i)
                    {
                        case "+":
                            ans=computadorsica.suma(a,b);
                            break;
                        case "-":
                            ans=computadorsica.resta(a,b);
                            break;
                        case "*":
                            ans=computadorsica.multiplicacion(a,b);
                            break;
                        case "/":
                            ans=computadorsica.division(a,b);
                            break;
                        default:
                            break;
                    }
                    operandos.push(ans);
                    break;
                default:
                    int j=Integer.parseInt(i);
                    operandos.push(j);
                    break;
            }

        }
        return operandos.pull();
    }
}
