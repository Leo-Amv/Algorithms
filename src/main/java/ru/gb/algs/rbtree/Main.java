package ru.gb.algs.rbtree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        RBTree rbTree = new RBTree();
        while(flag){
            try{
                rbTree.add(Integer.parseInt(input("Enter value to add:")));
                String exit = input("Continue?: 'y' / 'n' ").toLowerCase();
                if (exit.equals("n")){
                    flag = false;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
                flag = false;
            }
        }
        rbTree.showTree(1);
    }
    private static String input(String message) {
        String input = "";
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.print(message);
        try {
            input = sc.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sc.close();
        }
        return input;
    }
}

