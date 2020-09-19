package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Test2 {

    // A和B的最长公共子序列需小于length-1
    private static boolean legal(List<Integer> A , List<Integer> B){
        if(A.size() != B.size())
            return false;
        int[][] arr = new int[A.size() + 1][A.size() + 1];
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < B.size(); j++){
                if(A.get(i) == B.get(j)){
                    arr[i+1][j+1] = arr[i][j] + 1;
                }else {
                    arr[i+1][j+1] = Math.max(arr[i+1][j],arr[i][j+1]);
                }
//                if(i == j && arr[i+1][j+1] < i - 1){
//                    return true;
//                }
            }
        }
        return arr[A.size()][B.size()] < A.size() - 1;
    }

    // 所有长度为3的q元码
    private static  List<List<Integer>> allSet(int n , int q ){
        List<List<Integer>> result = new ArrayList<>();
        if(n == 1){
            for(int i = 0; i < q; i++){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                result.add(tmp);
            }
            return result;
        }
        List<List<Integer>> lists = allSet(n - 1, q);
        for(List<Integer> list : lists){
            for(int i = 0; i < q; i++){
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(list);
                tmp.add(i);
                result.add(tmp);
            }
        }
        return result;
    }

    // 一组完备码划分
    private static List<List<List<Integer>>> getResult(int n , int q){
        List<List<Integer>> lists = allSet(n, q);
        List<List<List<Integer>>> groups = new ArrayList<>();
        for(List<Integer> codes : lists){
            boolean divided = false;
            for(List<List<Integer>> group : groups){
                divided = true;
                for(List<Integer> divCode : group){
                    if(!legal(codes,divCode)){
                        divided = false;
                        break;
                    }
                }
                if(divided){
                    group.add(codes);
                    break;
                }
            }
            if(!divided){
                List<List<Integer>> newGroup = new ArrayList<>();
                newGroup.add(codes);
                groups.add(newGroup);
            }
        }
        return groups;
    }

    public static void main(String[] args) {

        List<List<List<Integer>>> result = getResult(3,3);
        for(List<List<Integer>> group : result){
            System.out.println("-------------------");
            for(List<Integer> codeWord : group){
                System.out.println(codeWord);
            }
        }

    }

}
