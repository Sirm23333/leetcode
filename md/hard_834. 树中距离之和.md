dp[u]表示以节点u为根节点的树，u到所有节点的距离之和
sz[u]表示以节点u为根节点的树，所有节点数量
rs[]表示最后结果

先以0为根节点遍历一遍树，构建dp和sz，则此时dp[0]即rs[0]

再通过dfs，让每一个节点都做一次根节点，即每次访问节点，就依次将它的子节点上升为根，状态转移方程为
```java
                dp[root] = dp[root] - dp[node] - sz[node] ;
                sz[root] = sz[root] - sz[node] ;
                dp[node] = dp[node] + dp[root] + sz[root] ;
                sz[node] = sz[node] + sz[root] ;
```
复杂度为O(n)