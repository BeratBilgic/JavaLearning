package javaBasic;

public class Foreach {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5,6,7,8,9,10};
        int nums2[][] = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9,},
                        };
                        
        for(int i : nums1)
        {
            System.out.println(i);
        }

        System.out.println();

        for(int[] k : nums2)
        {
            for(int j : k)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
