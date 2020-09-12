package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N, edges=0, a, b;
         //try(FileReader reader = new FileReader("input.txt"))
        try(FileReader reader = new FileReader("input2.txt"))
        {
            Scanner sc = new Scanner(reader);
            N = sc.nextInt();
            int[] isles = new int[N];
            int i=0;
            while(sc.hasNext()){
                a = sc.nextInt() - 1;
                b = sc.nextInt() - 1;
                if (isles[a]==0){
                    if (isles[b] == 0){
                        edges++;
                        isles[b]=isles[a]=edges;
                    }
                    else
                        isles[a] = isles[b];
                }
                else {
                    if (isles[b] == 0)
                        isles[b] = isles[a];
                    else {
                        int oldIsle = isles[b];
                        for (int j = 0; j < N; j++) {
                            if (isles[i] == oldIsle){
                                isles[i] = isles[a];
                            }
                        }
                        edges--;
                    }
                }
                i++;
            }
            for (int j = 0; j < N; j++)
                if (isles[j]==0)
                    edges++;
            System.out.println(edges-1);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
