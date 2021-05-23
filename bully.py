import math 
import os 
import random 
import re 
import sys 
elec=[]
ok=[]
def election(n): 
	for i in elec:
		for j in range(i+1,n):
			print("Election message sent from ",i," to ",j)

def okay(e,s): 
	c=0
	for i in range(e,len(s)): 
		if(s[i]!=0):
			print(i," sends ok") 
			elec.append(i) 
			c+=1
	if(c==0): 
		return(1)
	else:
		return(0)

n=list(map(int,input().split()))
s=list(map(int,input().split())) 
n.insert(0,0)
s.insert(0,0) 
print("nodes : ",n[1::])
print("Status : ",s[1::]) 
e=int(input())
print(e," is the initiator") 
elec.append(e)

for i in range(e,len(n)): 
	#print("i=",i) 
	election(len(n)) 
	#temp=min(elec)
	i=min(elec) 
	elec.clear() 
	if(okay(i+1,s)):
		break;
print(i," is the coordinator")
