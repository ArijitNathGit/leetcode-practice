package com.arijit.array;
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElementImpl().find(new int[] {3, 3, 4, 2, 4, 4, 2, 4, 4}));
    }
}

class MajorityElementImpl {
    public int find(int[] arr) {
        int possibleCandidate = findCandidate(arr);

        return (isMajority(arr, possibleCandidate)) ? possibleCandidate : -1;
    }

    private int findCandidate(int[] arr) {
        int majorIndex = 0, count = 1;

        for(int i = 1 ; i < arr.length; i++) {
            if( arr[majorIndex] == arr[i] ) count++;
            else count --;

            if(count == 0) {
                majorIndex = i;
                count = 1;
            }
        }

        return arr[majorIndex];
    }

    private boolean isMajority(int[] arr, int possibleMajority) {
        int count = 0;

        for(int num : arr) {
            if( num == possibleMajority ) count++;
        }

        return count > (arr.length / 2);
    }
}
