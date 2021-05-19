n=int(input('Enter the number of nodes:- ')) 
l=[]
print('\nPlease enter time in HH:MM format.\nEnter the time for:-') 
for i in range(n):
	print("Node",i+1,": ",end='') 
	l.append(input())
s=input('\nEnter the agreed upon time (in HH:MM format):- ') 
time=s[:3]
s=int(s[3:])


l1=[]
for i in l:
	l1.append(int(i[3:])) 
l2=l1.copy() 
l2.sort(reverse=True) 
print('\n')

a=['']*n
for i in range(n):
	print('Iteration',i+1,':') 
	for j in range(n):
		if(l1[j]==l2[i]):
			break
	print('Message is sent by node',chr(ord('a')+j),'.') 
	temp=[]
	t=0
	for k in range(n):
		t+=(l1[k]-s)
		temp.append(abs(l1[k]-s))

	temp.remove(0) 
	temp.sort()
	print('Interval time:',temp[0],' minutes.')


	for k in range(n):
		l1[k]+=temp[0] 
		l2[k]+=temp[0]

	t/=n
	print('Average computed =',t,' minutes.\n') 
	if(t<0):
		aob='behind'
	else:
		aob='ahead'


	a[j]='Node '+str(chr(ord('a')+j))+' moves '+aob+ ' by '+str(abs(t))+' minutes.'


for i in range(n):
	l1[i]-=temp[0]
	print(a[i])


print('\nThe SYNCHRONIZED TIME is: ',time+str(l1[j]+t),' minutes.')
