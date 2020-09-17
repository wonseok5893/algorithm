package com.wonseok.standard;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Boj1406 {
    static LinkedList<String> linkedList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String startStr = sc.nextLine();
        int arrSize = Integer.parseInt(sc.nextLine());
        String[] orders = new String[arrSize];

        String[] split = startStr.split("");
        linkedList = new LinkedList<String>(Arrays.asList(split));
        for (int i = 0; i < orders.length; i++) {
            orders[i] = sc.nextLine();
        }
        int pos = linkedList.size() - 1;
        for (String order : orders) {


                if (Character.toString(order.charAt(0)).equals("P")) {
                    linkedList.add(pos + 1, Character.toString(order.charAt(2)));
                    pos++;
                }

                if (Character.toString(order.charAt(0)).equals("L"))
                    if(pos!=0)
                    pos--;

                if (Character.toString(order.charAt(0)).equals("D"))
                    pos++;

                if (Character.toString(order.charAt(0)).equals("B")) {
                    linkedList.remove(pos);
                    pos--;
                }

            if (pos == 0 && Character.toString(order.charAt(0)).equals("P")) {
                linkedList.addFirst(Character.toString(order.charAt(2)));
                pos++;
            }else if (pos == linkedList.size()-1 && Character.toString(order.charAt(0)).equals("P")) {
                linkedList.addLast(Character.toString(order.charAt(2)));
                pos++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : linkedList) {
            sb.append(s + " ");
        }
        System.out.println(sb);
    }

}
