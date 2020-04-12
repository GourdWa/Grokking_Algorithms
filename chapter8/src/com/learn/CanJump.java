package com.learn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ZixiangHu
 * @create 2020-04-12  0:14
 * @description
 */
class SolutionCanJump {
    public boolean canJump(int[] nums) {
        int maxLoc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLoc)
                return false;
            maxLoc = Math.max(maxLoc, i + nums[i]);
        }
        return true;
    }
}

public class CanJump {
    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(new SolutionCanJump().canJump(arr));
    }
}
