public int findInMountainArray(int target, MountainArray mountainArr) {
    int maxIndex = getMaxValueIndex(mountainArr);
    int res = find(target, mountainArr, 0, maxIndex + 1, true);
    if (res == -1) {
        res = find(target, mountainArr, maxIndex, mountainArr.length(), false);
    }
    return res;
}

int getMaxValueIndex(MountainArray mountainArr) {
    int n = mountainArr.length();
    int l = 0, r = n;
    while (l < r) {
        int mid = (l + r) >>> 1;
        int m = mountainArr.get(mid);
        int left = mid > 0 ? mountainArr.get(mid - 1) : -1;
        int right = mid + 1 < n ? mountainArr.get(mid + 1) : -1;
        if (left == -1) {
            return m > right ? 0 : 1;
        } else if (right == -1) {
            return m > left ? n - 1 : n - 2;
        } else if (m > left && m < right) {
            l = mid + 1;
        } else if (m < left && m > right) {
            r = mid;
        } else if (m > left && m > right) {
            return mid;
        }
    }
    return 0;
}

int find(int target, MountainArray mountainArr, int l, int r, boolean left) {
    while (l < r) {
        int mid = (l + r) >>> 1;
        int m = mountainArr.get(mid);
        if (m > target) {
            if (left) {
                r = mid;
            } else {
                l = mid + 1;
            }
        } else if (m < target) {
            if (left) {
                l = mid + 1;
            } else {
                r = mid;
            }
        } else {
            return mid;
        }
    }
    return -1;
}
