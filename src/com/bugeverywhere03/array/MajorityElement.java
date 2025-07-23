package com.bugeverywhere03.array;

import java.util.HashMap;
import java.util.Map;


public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(nums));
    }

    // Solution 1
    // Sử dụng HashSet hoặc HashMap hoặc là Array/ArrayList để đếm số lần xuất hiện của phần tử đa số
    public static int majorityElement1(int[] nums) {
        // Tạo HashSet với key là phần tử trong mảng và value là số lần xuất hiện trong mảng
        Map<Integer, Integer> countMap = new HashMap<>();
        // Duyệt qua mảng để thêm tần xuất xuât hiện cho countMap
        for (int number: nums){
            // Lấy giá trị của key number trong countMap nếu chưa tồn tại trong map thì mặc định là 0
            int value = countMap.getOrDefault(number, 0);
            // Tăng số lần xuất hiện lên 1
            countMap.put(number, value + 1);
        }
        // Biến giữ gía trị của phần tử đa số
        int majorityElement = 0;
        // Biến giữ giá trị xuất hiện nhiều nhất hiện tại
        int maxAppears = 0;
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            if(entry.getValue() > maxAppears){
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
    // Solution 2
    // Chỉ sử dụng vòng lặp và biến phụ
    // Ý tưởng là phần tử đa số luôn xuất hiện nhiều nhất trong mảng vì vậy
    // Ta chỉ cần theo dõi phần tử nào có số lần xuất hiện nhiều nhất khi duyệt qua vòng lặp và thực hiên
    // Giảm số lần xuất hiện của phần tử majority hiện tại cho đến khi nó bằng 0 thì ta đổi thành phần tử khác
    // Cú như thế thì phần tử đa số luôn xuất hiện nhiều nhất thì đến một lúc nào đó ta sẽ tìm được phần tử majority
    // trong mảng
    public static int majorityElement2(int[] nums){
        // Định nghĩa ra một biến là số lần xuất hiện của biến majority hiện tại
        int currAppears = 0;
        int currMajority = nums[0];
        for (int number : nums){
            // Tăng hoặc giảm giá trị của currAppears tùy vào phần tử hiện tại có bằng currMajority không
            currAppears += number == currMajority ? 1 : - 1;
            if (currAppears == 0){
                currMajority = number;
                currAppears = 1;
            }
        }
        return currMajority;
    }
}
