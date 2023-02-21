
//
//
//  @ Project : hoja de trabajo 4
//  @ File Name : main_calculadora_postfix.java
//  @ Date : 31/01/2023
//  @ Author : Sofía Velásquez
//
//

import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
public class main_calculadora_postfix {

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        infix_to_postfix conversor= new infix_to_postfix();
        int opcion=0;
        while(opcion!=2)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Bienvenido a la calculadora infix-postfix \n Escoge una opcion\n 1.Calcular\n 2.Salir");
            ArrayList<String> lineas = new ArrayList<String>();
            opcion = in.nextInt(); 
            //Lectura de archivo
            if(opcion==1)
            {
                
                System.out.println("Ingrese el path");
                String path = in.nextLine();
                path = in.nextLine();
                File file = new File(path);
                try {
                    Scanner obj = new Scanner(file);
                    while (obj.hasNextLine())
                    {
                        String linea=obj.nextLine();
                        lineas.add(linea);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int i=1;
                System.out.println("Escoja que desea usar \n Escoge una opcion\n 1.Vector\n 2.ArrayList\n 3.Lista Simple\n 4.Lista doblemente encadenada");
                int opi = in.nextInt();
                IStack<Integer> operandos = St_Factory.make_stack(opi);       
                PostfixCalculator computadorsica = PostfixCalculator.getInstance(operandos);
                for (String str : lineas)
                {
                    String str2=infix_to_postfix.infixToPostfix(str);
                    String[] line = str2.split(" ");
                    System.out.println("    -El resultado es : "+calacular(line, computadorsica, operandos));
                    System.out.println("Linea No."+i+". Operacion postfix: "+str2);
                    i=i+1;
                }
            }
            else if (opcion==2)
            {
                System.out.println("Fin del programa, feliz día");
                break;
            }
            else
            {
                System.out.println("Dato incorrecto vuelva a intentar");
            }
        }
        //  System.out.println(lector.read(nombre_archivo));
    }

    /**
     * @param lista se ingresa una lista con los digitos para que se puedan hacer las operaciones
     * @return int
     */
    public static int calacular (String[] lista, PostfixCalculator computadorsica, IStack<Integer> operandos)
    {
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
