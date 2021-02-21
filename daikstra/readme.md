# 다익스트라 알고리즘
1. 출발 노드를 정한다.
2. 최단 거리 테이블을 초기화한다.
3. 방문하지 않은 노드 중 최단거리가 가자 짧은 노드를 선택한다.
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.

<pre>
<code>
     private static void daikstra(int startNode) {
            PriorityQueue<Node> queue = new PriorityQueue<>();
            boolean[]check = new boolean[v+1];
            queue.add(new Node(startNode,0));
            distance[startNode] = 0;
    
            while(!queue.isEmpty()){
                Node next = queue.poll();
                int nextEnd = next.end;
                if(check[nextEnd] == true)continue;
                check[nextEnd] = true;
                for (Node node : graph[nextEnd]) {
                    if(distance[node.end]>distance[nextEnd]+node.weight){
                        distance[node.end] = distance[nextEnd]+node.weight;
                        queue.add(new Node(node.end,distance[node.end]));
                    }
                }
            }
    
 
</code>
</pre>
방문하지 않은 가장 작은 가중치 선형 검색-> O(V^2)
우선순위 큐(힙)->O(E * log V)

# 플로이드 워셜
O(N^3)
<pre>
<code>
private static int[][] floydwarshall(int n, int[][] edges) {
        int[][]table = new int[n+1][n+1];
        for (int[] arr : table) {
            Arrays.fill(arr, (int)1e9+7);
        }
        for (int[] info : edges) {
            int start = info[0];
            int end = info[1];
            int weight = info[2];
            //초기 테이블 갱신
            table[start][end] = weight;
        }
        for (int i = 1; i <=n ; i++) {
            table[i][i] = 0;
        }
        // 자기 노드-> 자기노드 0으로 초기화

        for (int k = 1; k <=n ; k++) {
            for (int a = 1; a <=n ; a++) {
                if(k==a)continue;
                for (int b = 1; b <=n ; b++) {
                    if(b==a||b==k)continue;
                    table[a][b] = Math.min(table[a][b],table[a][k]+table[k][b]);
                }
            }
        }
        /// step 1 ~N까지 nP2만큼 a-> b > a->k + k->b
        return table;
    }
</code>
</pre>