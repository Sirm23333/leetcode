package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Test2 {

    /**
     * A和B是否可以放在一起
     * @param A
     * @param B
     * @return
     */
    private static boolean legalBetweenCodes(List<Integer> A , List<Integer> B){
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
                if(i == j && arr[i+1][j+1] < i - 1){
                    return true;
                }
            }
        }
        return arr[A.size()][B.size()] < A.size() - 1;
    }

    private static boolean[][] initLegalComArr(List<List<Integer>> lists){
        boolean[][]legalCom = new boolean[lists.size()][lists.size()];
        for(int i = 0; i < lists.size(); i++){
            for (int j = 0; j < lists.size(); j++){
                legalCom[i][j] = legalBetweenCodes(lists.get(i),lists.get(j));
            }
        }
        return legalCom;
    }
    /**
     * A是否可以放在group组
     * @param code
     * @param group
     * @return
     */
    private static boolean legal2Group(int code , List<Integer> group , boolean[][] legalComArr){
        for(int codeIdxInGroup : group){
            if(!legalComArr[codeIdxInGroup][code])
                return false;
        }
        return true;
    }

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

    /**
     *
     * @param groups
     * @param codes  所有码组集合的索引列表[0,1,2....q^n-1]
     * @param codesListIdx
     * @param n
     * @param q
     * @return
     */
    private static boolean dfs(List<List<Integer>> groups , List<Integer> codes , int codesListIdx , int n, int q , boolean[][] legalComArr){
        if(codesListIdx == codes.size() - 1){
            boolean b = islegal(groups,n,q);
            System.out.println(b);
            return b;
        }
        // codes[codesIdx]可以放的组
        int code = codes.get(codesListIdx);
        List<List<Integer>> optionals = getOptional(groups, code ,legalComArr );
        for(List<Integer> optGroup : optionals){
            optGroup.add(code);
            if(dfs(groups,codes,codesListIdx+1,n,q,legalComArr)){
                return true;
            }
            optGroup.remove(new Integer(code));
        }
        // 还可以单独一组
        if(groups.size() <= codes.size() / Math.pow(q,n-2)){
            List<Integer> newGroup = new ArrayList<>();
            newGroup.add(code);
            groups.add(newGroup);
            if(dfs(groups,codes,codesListIdx+1,n,q,legalComArr)){
                return true;
            }
            groups.remove(newGroup);
        }
        return false;
    }
    // 一组划分
    private static List<List<List<Integer>>> getResult(int n , int q){
        List<List<Integer>> lists = allSet(n, q);
        List<Integer> listsIdx = new ArrayList<>();
        for(int i = 0; i < lists.size(); i++){
            listsIdx.add(i);
        }
        boolean[][] legalComArr = initLegalComArr(lists);
        System.out.println(lists.size());
        System.out.println(lists);
        List<List<Integer>> idxGroups = new ArrayList<>();
        dfs(idxGroups,listsIdx,0,n,q,legalComArr);
        List<List<List<Integer>>> groups = new ArrayList<>();
        for(List<Integer> idxGroup : idxGroups){
            List<List<Integer>> group = new ArrayList<>();
            for(int idx : idxGroup){
                group.add(lists.get(idx));
            }
            groups.add(group);
        }

//        for(List<Integer> codes : lists){
//            boolean divided = false;
//            for(List<List<Integer>> group : groups){
//                divided = true;
//                for(List<Integer> divCode : group){
//                    if(!legal(codes,divCode)){
//                        divided = false;
//                        break;
//                    }
//                }
//                if(divided){
//                    group.add(codes);
//                    break;
//                }
//            }
//            if(!divided){
//                List<List<Integer>> newGroup = new ArrayList<>();
//                newGroup.add(codes);
//                groups.add(newGroup);
//            }
//        }
        return groups;
    }

    /**
     * 获得code可以被分配到groups的哪些集合
     * @param groups
     * @param code 码组集合的索引
     * @return
     */
    private static List<List<Integer>> getOptional(List<List<Integer>> groups , int code , boolean[][] legalComArr){
        List<List<Integer>> optional = new ArrayList<>();
        for(List<Integer> group : groups){
            if(legal2Group(code,group,legalComArr)){
                optional.add(group);
            }
        }
        return optional;
    }
    // 判断划分是不是完备码
    private static boolean islegal(List<List<Integer>> result , int n , int q){
        for(List<Integer> list : result){
            if(list.size() < Math.pow(q,n-2))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {

        List<List<List<Integer>>> result = getResult(3,3);
        for(List<List<Integer>> group : result){
            System.out.println("-------------------");
            for(List<Integer> codeWord : group){
                System.out.println(codeWord);
            }
        }
//        List<List<Integer>> l1 = new ArrayList<>();
//        List<List<Integer>> l2 = new ArrayList<>();
//        List<Integer> tmp = new ArrayList<>();
//        tmp.add(1);
//        l1.add(tmp);
//        l2.add(tmp);
//        l2.get(0).add(2);
//        System.out.println(l1.get(0).size());
    }

}
