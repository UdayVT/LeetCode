class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        counter = defaultdict(int)

        for edge in edges:
            for vert in edge:
                counter[vert] += 1
        
        return max(counter.items(), key=lambda x: x[1])[0]
        