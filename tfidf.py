#!/usr/bin/python
from dataFilter import generateComments
import string
import os
import json
import nltk.corpus
from pprint import pprint
from collections import defaultdict
from math import log10

def TFIDF(comments, applyIDF = True):
#"""
#Given a list of list of tokens (1 per comment), construct a nested tfidf
#representation. Uses dictionary representation given sparsity.
#Dictionaries are returned as normal dictionaries. Returns list of dictionaries
#	
#:param comments: list of list of tokens
#:param applyIDF: if true result is TF-IDF, if false results is TF (default: True)
#"""
# treat each comment as a document
	idf = defaultdict(lambda: 0.0)
	# we return a list of dictionaries, as data is sparse
	tfidf = []
	for comment in comments:
		tf = defaultdict(lambda: 0.0)
		for term in comment:
			tf[term] += 1.0
		tfidf.append(tf)    
		if applyIDF:
			# aggregate idf
			for k in tf.keys():
				idf[k] += 1
		
	if applyIDF:
		N = len(tfidf)
		for i in range(N):
			# get rid of defaultdict, no longer needed
			tf = dict(tfidf[i])
			for term in tf.keys():
				# add-one smoothing
				tf[term] *= log10(float(N) / (1.0 + idf[term]))  
			tfidf[i] = tf
	return tfidf  
#
#def documents(folderPath,nums):
#	comments=[]
#	for i in range(nums):
#		filePath = folderPath+'/text'+str(i)+'.txt'
#		comments.append(generateComments(filePath))
#	return comments
#
#path = '/Users/huangrui199126/Desktop/article'
#print TFIDF(documents(path,10))