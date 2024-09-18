class Solution:
    def repeatedCharacter(self, s: str) -> str:
        letter_seen = []
        for c in s:
            if c in letter_seen:
                return c
            else:
                letter_seen.append(c)