#!/usr/bin/python

class k_means:
	
	  count1,count2,count3;
	  d[];
	  k[][];
	  tempk[][];
	 double m[];
	 double diff[];
	  n,p;

	// This method will determine the cluster which an element will go.
	  cal_diff( a) 
	
		 temp1=0;
		for i in range(p):
		
			diff[i]=Math.abs(a-m[i]);
		
		 val=0;
		double temp=diff[0];
		for i in range(p):
		
			if(diff[i]<temp)
			
				temp=diff[i];
				val=i;
			
		//end of for loop
		return val;
	

	// This method will determine ermediate mean values
	 void cal_mean() 
	
		for i in range(p):
			m.append(0); // initializing means to 0
		 cnt=0;
		for i in range(p):
		
			cnt=0;
			for i in range(n-1):
			
				if(k[i][j]!=-1)
				
					m[i]+=k[i][j];
					cnt++;
				
			m[i]=m[i]/cnt;
		
	

	  check1() // This checks if previous k ie. tempk and current k are same.Used as terminating case.
	
		for i in range(p):
			for j in range(n):
			if(tempk[i][j]!=k[i][j])
		
			return 0;
		
		return 1;
	
n=8;
d={1,2,3,4,5,6,7,8};
p=4;
		k=new [p][n];
		tempk=new [p][n];
		m=new double[p];
		diff=new double[p];
		/* Initializing m */
		for i in range(p):
			m[i]=d[i];

		 temp=0;
		 flag=0;
		do
		
			for i in range(p):
				for j in range(n):
			
				k[i][j]=-1;
			
			for( i=0;i<n;++i) // for loop will cal cal_diff() for every element.
			
				temp=cal_diff(d[i]);
				if(temp==0)
					k[temp][count1++]=d[i];
				else
					if(temp==1)
					k[temp][count2++]=d[i];
					else
					if(temp==2)
					k[temp][count3++]=d[i]; 
					
			cal_mean(); // call to method which will calculate mean at this step.
			flag=check1(); // check if terminating condition is satisfied.
			if(flag!=1)
				/*Take backup of k in tempk so that you can check for equivalence in next step*/
				for i in range(p):
				for j in range(n):
				tempk[i][j]=k[i][j];

				print "\n\nAt this step"
				print "\nValue of clusters"
			for i in range(p):
			
				print "K"+(i+1)+" "
				for( j=0;k[i][j]!=-1 && j<n-1;++j)
					print k[i][j]+" "
				print ""
			//end of for loop
			print "\nValue of m "
			for i in range(p):
				print "m"+(i+1)+"="+m[i]+"  "

			count1=0;count2=0;count3=0;
		
		while(flag==0);

		print "\n\n\nThe Final Clusters By Kmeans are as follows: "
		for i in range(p):
		
			print "K"+(i+1)+" "
			for( j=0;k[i][j]!=-1 && j<n-1;++j)
				print k[i][j]+" "
			print ""
		
	

