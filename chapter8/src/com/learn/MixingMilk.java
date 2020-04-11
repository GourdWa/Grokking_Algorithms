package com.learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-11  19:11
 * @description
 */
class Milk implements Comparable<Milk> {
    private int num;
    private int price;

    public Milk() {
    }

    public Milk(int num, int price) {
        this.num = num;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "num=" + num +
                ", price=" + price +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Milk o) {
        return this.price - o.price;
    }
}

public class MixingMilk {
    //传入排好序的牛奶
    public static int getMinCost(Milk[] milks, int amount) {
        int cost = 0;
//        int have = 0;
        for (int i = 0; i < milks.length; i++) {
            if (milks[i].getNum() <= amount) {
                cost += milks[i].getNum() * milks[i].getPrice();
                amount -= milks[i].getNum();
            } else {
                cost += amount * milks[i].getPrice();
                break;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //总共需要多少牛奶
        int amount = sc.nextInt();
        Milk[] milks = new Milk[n];
        for (int i = 0; i < milks.length; i++) {
            milks[i] = new Milk(new Random().nextInt(100), new Random().nextInt(100));
        }
        for (Milk milk : milks) {
            System.out.println(milk.getNum() + " " + milk.getPrice());
        }
        System.out.println("*******************");
        Arrays.sort(milks);
        System.out.println(getMinCost(milks, amount));

    }
}
