package hard;

import java.util.ArrayList;
import java.util.List;

/**
 *834. 树中距离之和
 * (树型dp)
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 *
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 *
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 *
 * 示例 1:
 *
 * 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释:
 * 如下为给定的树的示意图：
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 *
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test_834 {
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        // 建树
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < N; i++){
            tree.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[N];
        int[] dp = new int[N];
        int[] sz = new int[N]; // 每一棵树的子节点数量（不包括根）
        int[] rs = new int[N];
        dp(tree,0,visited,dp,sz);
        visited = new boolean[N];
        dp2(tree,0,visited,dp,sz,rs);
        return rs;
    }
    public static void dp(List<List<Integer>> tree , int root , boolean[] visited, int[] dp , int sz[]){
        visited[root] = true;
        for(Integer node : tree.get(root)){
            if(!visited[node]){
                dp(tree,node,visited,dp,sz);
                dp[root] += dp[node];
                sz[root] += sz[node];
            }
        }
        sz[root]++;
        dp[root] += (sz[root]-1);
    }
    public static void dp2(List<List<Integer>> tree , int root, boolean[] visited , int[] dp, int sz[] ,  int[] rs){
        rs[root] = dp[root];
        visited[root] = true;
        for(Integer node : tree.get(root)){
            if(!visited[node]){
                int preRoot = dp[root];
                int preNode = dp[node];
                int preRootSz = sz[root];
                int preNodeSz = sz[node];
                dp[root] = dp[root] - dp[node] - sz[node] ;
                sz[root] = sz[root] - sz[node] ;
                dp[node] = dp[node] + dp[root] + sz[root] ;
                sz[node] = sz[node] + sz[root] ;
                dp2(tree,node,visited,dp,sz,rs);
                dp[root] = preRoot;
                dp[node] = preNode;
                sz[root] = preRootSz;
                sz[node] = preNodeSz;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        sumOfDistancesInTree(6,arr);
    }
}
