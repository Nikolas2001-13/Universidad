{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf600
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 #!/bin/bash\
\
$t=0;\
while [$t <>5]\
do\
	echo \'93Opciones:\'94\
	echo \'931. Limpiar Pantalla\'94\
	echo \'932. Buscar Palabra\'94\
	echo \'933. Informacion sobre usuarios\'94\
	echo \'934. Listar Archivos\'94\
	\
	echo \'93Escoja una opcion: \'94\
	read op\
	if [$op == 1]\
		source sh1.sh\
	fi\
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0
\cf0 	if [$op == 2]\
		source sh2.sh\
	fi\
	if [$op == 3]\
		source sh3.sh\
	fi\
	if [$op == 4]\
		source sh4.sh\
	fi\
	if [$op == 5]\
		exit\
	fi\
done}