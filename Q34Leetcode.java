// Find the 1st and last occurrence of a number in a sorted array?


public class Q34Leetcode {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,3,3,4,4,5};
        int target = 3;

        int left = findLeft(arr, target);
        int right = findRight(arr, target);

        System.out.println("Leftmost index: " + left);
        System.out.println("Rightmost index: " + right);
    }

    public static int findLeft(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if( arr[mid] > target) {
                right = mid - 1;
            }
            else {
                idx = mid;
                right = mid - 1;
            }
        }

        return idx;
    }

    public static int findRight(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if( arr[mid] > target) {
                right = mid - 1;
            }
            else {
                idx = mid;
                left = mid + 1;
            }
        }

        return idx;
    }
}
