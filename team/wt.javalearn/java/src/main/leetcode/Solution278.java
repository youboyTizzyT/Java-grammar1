package leetcode;

/**
 * 第一个错误版本
 * Create by weicong on 2018/10/10
 */
public class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution278 solution278 = new Solution278();
        System.out.println(solution278.firstBadVersion(1));
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        if (version == 5) {
            return true;
        } else if (version == 2) {
            return false;
        } else {
            return version == 4;
        }
    }
}
