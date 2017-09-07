# 535A : TAVAS AND NAFAS
# Prerequisite : Implementation

dictionary={
0:'zero', 	10:'ten',
1:'one', 	11:'eleven',
2:'two', 	12:'twelve',  	20:'twenty',
3:'three', 	13:'thirteen',	30:'thirty',
4: 'four', 	14:	'fourteen', 40:	'forty',
5: 'five', 	15:	'fifteen',  50:	'fifty',
6: 	'six', 	16:	'sixteen', 	60:	'sixty',
7:	'seven',17:	'seventeen',70:	'seventy',
8: 	'eight',18:	'eighteen', 80:	'eighty',
9: 	'nine',	19:	'nineteen', 90:	'ninety'
}

n=int(raw_input())
if(n<=20 or n%10==0):print dictionary[n]
else: print '{}-{}'.format(dictionary[(n//10)*10],dictionary[n%10])
