'''
> Trie 알고리즘
- 문자열을 Tree 형식으로 만들어 보다 빠르게 문자열 검색이 가능한 자료구조
- O(m) (m은 문자열의 길이)라는 짧은 시간이 소요됨
- 문자열을 검색하는 문제에서 입력되는 문자열이 많은 경우 자주 사용됨
'''
import sys
input = sys.stdin.readline

class Node(object):
    def __init__(self, has_end=False):
        self.has_end = has_end
        self.children = dict()

class Trie(object):
    def __init__(self):
        self.head = Node(None)
    def insert(self, num): # 트리 모양으로 데이터 삽입
        curr_node = self.head
        for d in num:
            # 현재 노드에 자식이 없는 경우
            if curr_node.children.get(d) is None:
                curr_node.children[d] = Node() # 생성
            curr_node = curr_node.children[d] # 해당하는 숫자의 자식으로 이동
        curr_node.has_end = True

    def search(self, num):
        curr_node = self.head
        for d in num:
            # 해당하는 숫자의 자식이 없으면 일관성 있음
            if curr_node.children.get(d) is None:
                return True
            curr_node = curr_node.children[d]
            if curr_node.has_end: # 해당하는 숫자에서 끝난다면 일관성 없음
                return False
        return True

if __name__== "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        numbers = [input().rstrip() for _ in range(n)]

        #lambda 함수는 (len(x), x) 튜플을 반환
        #numbers는 이러한 튜플로 이루어진 리스트
        numbers = list(map(lambda x: (len(x), x), numbers))
        numbers.sort(key=lambda x:x[0]) #길이에 따라 정렬

        data = Trie()

        for _, number in numbers:
            if data.search(number) == False:
                print("NO")
                break
            data.insert(number)
        else:
            print("YES")