from sys import stdin

def rec(acum, i):
    global nums
    if i == len(nums):
        return acum == 23
    else:
        ans = rec(acum + nums[i], i + 1)
        ans = ans or rec(acum - nums[i], i + 1)
        ans = ans or rec(acum * nums[i], i + 1)
        return ans
    

def main():
    global nums
    nums = [int(x) for x in stdin.readline().split()]
    ans = rec(nums[0], 1)
    if ans:
        print('Possible')
    else:
        print('Impossible')

main()
