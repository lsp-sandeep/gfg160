class Solution:
	def mergeOverlap(self, arr):
		#Optimized Approach
		arr.sort()
		n = len(arr)
		res = [arr[0]]
		for i in range(1, n):
			start, end = arr[i][0], arr[i][1]
			if start <= res[-1][1]:
				res[-1][1] = max(res[-1][1], end)
			else:
				res.append([start, end])
		
		return res