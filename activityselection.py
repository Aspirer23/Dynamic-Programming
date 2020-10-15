import random
def partition(array,s, low, high):

    pivot = array[high]
    i = low - 1
    for j in range(low, high):
        if array[j] <= pivot:
            i = i + 1
            (array[i], array[j]) = (array[j], array[i])
            (s[i], s[j]) = (s[j], s[i])
    (array[i + 1], array[high]) = (array[high], array[i + 1])
    (s[i + 1], s[high]) = (s[high], s[i + 1])
    return i + 1

def quicksort(array,s,low, high):
    if low < high:
        pi = partition(array,s,low, high)
        quicksort(array,s, low, pi - 1)
        quicksort(array,s, pi + 1, high)

def activityselection(start, finish,n ): 
    quicksort(finish,start,0,n-1)
    print("The activities selected are as follow ---")
    i = 0
    print (i,end=" ") 
    for j in range(n): 
        if start[j] >= finish[i]: 
            print (j, end=" ")
            i = j 
    print()
##the array start and finish is of length 65
start=[]
finish=[]
n=65
for i in range(0,n):
   tempstart=random.randint(1,94)
   tempfinish=tempstart+random.randint(1,5)
   start.append(tempstart)
   finish.append(tempfinish) 
start = [5 , 3 , 0 , 5 , 8 , 1] 
finish = [9 , 4 , 6 , 7 , 9 , 2] 
n=6
activityselection(start, finish,n) 