##  PATCHNOTES
##1)ПЕРЕПИСАНЫ ПОСЛЕДНИЕ 150 СТРОК КОДА
##2)ДОБАВЛЕНА ФУНКЦИЯ ВОЗВРАЩЕНИЯ ХОДОВ - ДЛЯ ЭТОГО НУЖНО ВВЕСТИ ЧИСЛО,
##  НА СКОЛЬКО ХОДОВ НУЖНО ОТКАТИТЬ
##    ЭТО Я ПИСАЛ 3 ЧАСА))
##3)в консоли теперь есть полезная инфа
##4)рокировки можно делать, есть проверка на то что король не ходил(не тестил), указывать рокировку ходом с короля на ладью
##upd.час сидел чинил чтобы работало за обе стороны и нормально работало с возвратом ходов, жду баг репорты
##5)когда закрываешь меню ввода то игра не закрывается
##6)консоль ещё раз реворкнул
##7)пешки можно менять на другие фигуры
##8)адаптировал пункт 7 под возвращение ходов
##9)написал некоторые условия для хода
## BETA:
##10)взятие на проходе сделал
##11) сделаны все условия ходов кроме прохождения сквозь фигуры (надо написать)
##12) возвращение ходов работает плохо с взятием на проходе
##13) можно хавать назад но похер (не баг а фича)
##14) ПОКА СЛОМАНО (уже нет)
##15) оно работает но как то слишком комедийно (если очень захотеть то можно не в свой ход сходить я хз как это сделать я не смог повторить)
##16) легенда йоу!!!!!!!!!!!
##17) взятие на проходе сломано, доведение пешек сломано, не прописаны условия ходьбы для ферзя и слона, не уверен что для чёрных всё работает
##18) если съесть чёрного короля то происходит комедия
from turtle import *
kingBm=0
kingWm=0
lastmove='m0'
def land():
    up()
    goto(-400,-400)
    pd()
    fillcolor(colwhite)
    begin_fill()
    goto(400,-(4)*100)
    goto(400,-(4)*100+100)
    goto(-400,-(4)*100+100)
    goto(-400,-(4)*100)
    end_fill()
    up()
    goto(-400,400)
    for s in range(4):
        fillcolor(colblack)
        goto((-4)*100+200*s,-400)
        pd()
        begin_fill()
        goto((-4)*100+200*s,400)
        goto((-4)*100+100+200*s,400)
        goto((-4)*100+100+200*s,-400)
        goto((-4)*100+200*s,-400)
        end_fill()
        pu()
    for s in range(4):
        fillcolor(colwhite)
        pu()
        goto(-400,(4)*100-200*s)
        pd()
        begin_fill()
        goto(400,(4)*100-200*s)
        goto(400,(4)*100-100-200*s)
        goto(-400,(4)*100-100-200*s)
        goto(-400,(4)*100-200*s)
        end_fill()
        pu()
    for s in range(4):
        fillcolor(colblack)
        goto((-3)*100+200*s,-300)
        pd()
        begin_fill()
        goto((-3)*100+200*s,400)
        goto((-3)*100+100+200*s,400)
        goto((-3)*100+100+200*s,-300)
        goto((-3)*100+200*s,-300)
        end_fill()
        pu()
    for s in range(3):
        fillcolor(colwhite)
        pu()
        goto(-300,(3)*100-200*s)
        pd()
        begin_fill()
        goto(400,(3)*100-200*s)
        goto(400,(3)*100-100-200*s)
        goto(-300,(3)*100-100-200*s)
        goto(-300,(3)*100-200*s)
        end_fill()
        pu()
    for s in range(3):
        fillcolor(colblack)
        goto((-2)*100+200*s,-200)
        pd()
        begin_fill()
        goto((-2)*100+200*s,400)
        goto((-2)*100+100+200*s,400)
        goto((-2)*100+100+200*s,-200)
        goto((-2)*100+200*s,-200)
        end_fill()
        pu()
    for s in range(3):
        fillcolor(colwhite)
        pu()
        goto(-200,(4)*100-200*s)
        pd()
        begin_fill()
        goto(400,(4)*100-200*s)
        goto(400,(4)*100-100-200*s)
        goto(-200,(4)*100-100-200*s)
        goto(-200,(4)*100-200*s)
        end_fill()
        pu()
    for s in range(3):
        fillcolor(colblack)
        goto((-1)*100+200*s,-100)
        pd()
        begin_fill()
        goto((-1)*100+200*s,400)
        goto((-1)*100+100+200*s,400)
        goto((-1)*100+100+200*s,-100)
        goto((-1)*100+200*s,-100)
        end_fill()
        pu()
    for s in range(2):
        fillcolor(colwhite)
        pu()
        goto(-100,(3)*100-200*s)
        pd()
        begin_fill()
        goto(400,(3)*100-200*s)
        goto(400,(3)*100-100-200*s)
        goto(-100,(3)*100-100-200*s)
        goto(-100,(3)*100-200*s)
        end_fill()
        pu()
    goto(0,0)
    pd()
    fillcolor(colblack)
    begin_fill()
    goto(0,300)
    goto(300,300)
    goto(300,0)
    goto(0,0)
    end_fill()
    pu()
    goto(100,100)
    pd()
    fillcolor(colwhite)
    begin_fill()
    goto(100,0)
    goto(200,0)
    goto(200,100)
    goto(300,100)
    goto(300,200)
    goto(200,200)
    goto(200,300)
    goto(100,300)
    goto(100,200)
    goto(0,200)
    goto(0,100)
    goto(100,100)
    end_fill()
    pu()
    goto(200,200)
    pd()
    fillcolor(colblack)
    begin_fill()
    goto(200,100)
    goto(100,100)
    goto(100,200)
    goto(200,200)
    end_fill()
def Squares():
    pu()
    goto(-400,-400)
def Letter():
    pu()
    goto(-380,-480)#A
    pd()
    goto(-350,-420)
    goto(-335,-450)
    goto(-365,-450)
    goto(-335,-450)
    goto(-320,-480)
    pu()
    goto(-280,-480)#b
    pd()
    goto(-280,-420)
    goto(-240,-420)
    goto(-220,-435)
    goto(-240,-450)
    goto(-280,-450)
    goto(-240,-450)
    goto(-220,-465)
    goto(-240,-480)
    goto(-280,-480)
    pu()
    goto(-120,-435)#c
    pd()
    goto(-140,-420)
    goto(-160,-420)
    goto(-180,-435)
    goto(-180,-465)
    goto(-160,-480)
    goto(-140,-480)
    goto(-120,-465)
    pu()
    goto(-80,-480)#d
    pd()
    goto(-80,-420)
    goto(-40,-420)
    goto(-20,-435)
    goto(-20,-465)
    goto(-40,-480)
    goto(-80,-480)
    pu()
    goto(20,-435)#e
    pd()
    goto(80,-435)
    goto(60,-420)
    goto(40,-420)
    goto(20,-435)
    goto(20,-465)
    goto(40,-480)
    goto(60,-480)
    goto(80,-465)
    pu()
    goto(120,-480)#f
    pd()
    goto(120,-450)
    goto(180,-450)
    goto(120,-450)
    goto(120,-420)
    goto(180,-420)
    pu()
    goto(280,-435)#g
    pd()
    goto(260,-420)
    goto(240,-420)
    goto(220,-435)
    goto(220,-465)
    goto(240,-480)
    goto(260,-480)
    goto(280,-465)
    goto(260,-465)
    pu()
    goto(320,-480)#h
    pd()
    goto(320,-420)
    goto(320,-450)
    goto(320,-450)
    goto(380,-450)
    goto(380,-450)
    goto(380,-420)
    goto(380,-480)
    pu()

def Numb():
    pu()
    goto(-430,-380)#1
    pd()
    goto(-430,-320)
    goto(-440,-340)
    pu()
    goto(-430,-280)#2
    pd()
    goto(-440,-280)
    goto(-430,-220)
    goto(-440,-240)
    pu()
    goto(-440,-175)#3
    pd()
    goto(-435,-180)
    goto(-430,-160)
    goto(-440,-150)
    goto(-430,-140)
    goto(-435,-120)
    goto(-440,-125)
    pu()
    goto(-430,-80)#4
    pd()
    goto(-430,-20)
    goto(-430,-40)
    goto(-440,-40)
    goto(-440,-20)
    pu()
    goto(-430,80)#5
    pd()
    goto(-440,80)
    goto(-440,60)
    goto(-430,40)
    goto(-440,20)
    pu()
    goto(-430,180)#6
    pd()
    goto(-440,160)
    goto(-440,140)
    goto(-435,120)
    goto(-430,140)
    goto(-440,160)
    pu()
    goto(-440,280)#7
    pd()
    goto(-430,280)
    goto(-435,250)
    goto(-440,250)
    goto(-430,250)
    goto(-435,250)
    goto(-440,220)
    pu()
    goto(-435,380)#8
    pd()
    goto(-430,360)
    goto(-440,340)
    goto(-435,320)
    goto(-430,340)
    goto(-440,360)
    goto(-435,380)
    pu()
def DrawWhitePawn(x,y):
    goto(x+50,y+50)
    dot(32,"black")
    dot(30,colpiecewhite)
    
def DrawWhiteRook(x,y):
    goto(x+20,y)
    pd()
    begin_fill()
    goto(x+20,y+50)
    goto(x+10,y+50)
    goto(x+10,y+80)
    goto(x+30,y+80)
    goto(x+30,y+70)
    goto(x+40,y+70)
    goto(x+40,y+80)
    goto(x+60,y+80)
    goto(x+60,y+70)
    goto(x+70,y+70)
    goto(x+70,y+80)
    goto(x+90,y+80)
    goto(x+90,y+50)
    goto(x+80,y+50)
    goto(x+80,y)
    end_fill()
    up()
def DrawWhiteKnight(x,y):
    goto(x+15,y)
    pd()
    begin_fill()
    goto(x+50,y+50)
    goto(x+15,y+40)
    goto(x+15,y+60)
    goto(x+40,y+80)
    goto(x+70,y+80)
    goto(x+80,y+70)
    goto(x+70,y+50)
    goto(x+85,y)
    end_fill()
    up()
def DrawWhiteElephant(x,y):
    goto(x+15,y)
    begin_fill()
    pd()
    goto(x+50,y+50)
    goto(x+75,y+80)
    goto(x+50,y+90)
    goto(x+25,y+80)
    goto(x+50,y+50)
    goto(x+85,y)
    pu()
    end_fill()
def DrawWhiteQueen(x,y):
    goto(x+20,y)
    pd()
    begin_fill()
    goto(x+20,y+90)
    goto(x+30,y+50)
    goto(x+50,y+90)
    goto(x+70,y+50)
    goto(x+80,y+90)
    goto(x+80,y)
    pu()
    goto(x+50,y+40)
    pd()
    goto(x+60,y+50)
    goto(x+50,y+60)
    goto(x+40,y+50)
    goto(x+50,y+40)
    end_fill()
    up()
def DrawWhiteKing(x,y):
    goto(x+15,y)
    pd()
    begin_fill()
    goto(x+15,y+70)
    goto(x+30,y+50)
    goto(x+50,y+70)
    goto(x+70,y+50)
    goto(x+85,y+70)
    goto(x+85,y)
    end_fill()
    up()
def DrawBlackPawn(x,y):
    goto(x+50,y+50)
    dot(30,colpieceblack)
def DrawBlackRook(x,y):
    goto(x+20,y)
    pd()
    begin_fill()
    goto(x+20,y+50)
    goto(x+10,y+50)
    goto(x+10,y+80)
    goto(x+30,y+80)
    goto(x+30,y+70)
    goto(x+40,y+70)
    goto(x+40,y+80)
    goto(x+60,y+80)
    goto(x+60,y+70)
    goto(x+70,y+70)
    goto(x+70,y+80)
    goto(x+90,y+80)
    goto(x+90,y+50)
    goto(x+80,y+50)
    goto(x+80,y)
    end_fill()
    up()
def DrawBlackKnight(x,y):
    goto(x+15,y)
    pd()
    begin_fill()
    goto(x+50,y+50)
    goto(x+15,y+40)
    goto(x+15,y+60)
    goto(x+40,y+80)
    goto(x+70,y+80)
    goto(x+80,y+70)
    goto(x+70,y+50)
    goto(x+85,y)
    end_fill()
    up()
def DrawBlackElephant(x,y):
    goto(x+15,y)
    pd()
    begin_fill()
    goto(x+50,y+50)
    goto(x+75,y+80)
    goto(x+50,y+90)
    goto(x+25,y+80)
    goto(x+50,y+50)
    goto(x+85,y)
    end_fill()
    up()
def DrawBlackQueen(x,y):
    goto(x+20,y)
    pd()
    begin_fill()
    goto(x+20,y+90)
    goto(x+30,y+50)
    goto(x+50,y+90)
    goto(x+70,y+50)
    goto(x+80,y+90)
    goto(x+80,y)
    pu()
    goto(x+50,y+40)
    pd()
    goto(x+60,y+50)
    goto(x+50,y+60)
    goto(x+40,y+50)
    goto(x+50,y+40)
    end_fill()
    up()
def DrawBlackKing(x,y):
    goto(x+15,y)
    pd()
    begin_fill()
    goto(x+15,y+70)
    goto(x+30,y+50)
    goto(x+50,y+70)
    goto(x+70,y+50)
    goto(x+85,y+70)
    goto(x+85,y)
    end_fill()
    up()
def DrawPoint(x,y):
    goto(x+50,y+50)
    dot(30,colCorrectMove)
proms=[]
pawnsW=[0]*8
pawnsB=[0]*8
white=['a2','b2','c2','d2','e2','f2','g2','h2','a1','h1','b1','g1','c1','f1','d1','e1']
black=['a7','b7','c7','d7','e7','f7','g7','h7','a8','h8','b8','g8','c8','f8','d8','e8']
whites=['a2','b2','c2','d2','e2','f2','g2','h2','a1','h1','b1','g1','c1','f1','d1','e1']
blacks=['a7','b7','c7','d7','e7','f7','g7','h7','a8','h8','b8','g8','c8','f8','d8','e8']
Letters={'a':-400, 'b':-300, 'c':-200, 'd':-100, 'e':0, 'f':100, 'g':200, 'h':300}
Numbers={'1':-400, '2':-300, '3':-200, '4':-100, '5':0, '6':100, '7':200, '8':300}
def DrawAllWhite(whites,Letters,Numbers,piecesWhite):
    fillcolor(colpiecewhite)
    for i in range(15):
        piece=piecesWhite[i]
        if piece=='pawn':
            if whites[i][0] in Letters:
                DrawWhitePawn(Letters[whites[i][0]],Numbers[whites[i][1]])
        if piece=='rook':
            if whites[i][0] in Letters:
                DrawWhiteRook(Letters[whites[i][0]],Numbers[whites[i][1]])
        if piece=='knight':
            if whites[i][0] in Letters:
                DrawWhiteKnight(Letters[whites[i][0]],Numbers[whites[i][1]])
        if piece=='bishop':
            if whites[i][0] in Letters:
                DrawWhiteElephant(Letters[whites[i][0]],Numbers[whites[i][1]])
        if piece=='queen':
            if whites[i][0] in Letters:
                DrawWhiteQueen(Letters[whites[i][0]],Numbers[whites[i][1]])
    DrawWhiteKing(Letters[whites[15][0]],Numbers[whites[15][1]])
def DrawAllBlack(blacks,Letters,Numbers,piecesBlack):
    fillcolor(colpieceblack)
    for i in range(15):
        piece=piecesBlack[i]
        if piece=='pawn':
            if blacks[i][0] in Letters:
                DrawBlackPawn(Letters[blacks[i][0]],Numbers[blacks[i][1]])
        if piece=='rook':
            if blacks[i][0] in Letters:
                DrawBlackRook(Letters[blacks[i][0]],Numbers[blacks[i][1]])
        if piece=='knight':
            if blacks[i][0] in Letters:
                DrawBlackKnight(Letters[blacks[i][0]],Numbers[blacks[i][1]])
        if piece=='bishop':
            if blacks[i][0] in Letters:
                DrawBlackElephant(Letters[blacks[i][0]],Numbers[blacks[i][1]])
        if piece=='queen':
            if blacks[i][0] in Letters:
                DrawBlackQueen(Letters[blacks[14][0]],Numbers[blacks[14][1]])
    DrawBlackKing(Letters[blacks[15][0]],Numbers[blacks[15][1]])
def DrawField(Letters,Numbers,blacks,whites):
    up()
    screensize(10000,10000,colbg)
    goto(-400,400)
    for x in range(-400,500,100):
        goto(x,-400)
        pd()
        goto(x,400)
        up()
    for x in range(-400,500,100):
        goto(400,x)
        pd()
        goto(-400,x)
        up()
    land()
    Letter()
    Numb()
    DrawAllBlack(blacks,Letters,Numbers,piecesBlack)
    DrawAllWhite(whites,Letters,Numbers,piecesWhite)

def reverse(prevmoves,x,white,black):
    kingBm=0
    kingWm=0
    print(f'returned {x} steps')
    reset()
    whites2=[0]*16
    blacks2=[0]*16
    piecesBlack=[x for x in piB]
    piecesWhite=[x for x in piW]
    k=0
    prevmoves2=prevmoves
    prevmoves=[prevmoves2[i] for i in range(len(prevmoves)-x)]
    for i in range(16):
        whites2[i]=white[i]
    for i in range(16):
        blacks2[i]=black[i]
    for i in range(len(prevmoves)):
        if i%2==0:
            move=prevmoves[i]
            pos1=str(move)[:2]
            pos2=str(move)[2:]
            if pos1==whites2[15]:
                kingWm=1
            if whites2.index(pos1) in range(0,8):
                pawnsW[whites2.index(pos1)]=1
            if pos2 in whites2:
                if pos1==whites2[15] and kingWm==0 and pos2 == 'a1' and whites2.index(pos2) in [8,9]:
                    whites2[15]='b1'
                    whites2[whites2.index('a1')]='c1'
                    kingWm=1
                elif pos1==whites2[15] and kingWm==0 and pos2=='h1' and whites2.index(pos2) in [8,9]:
                    whites2[15]='g1'
                    whites2[whites2.index('h1')]='f1'
                    kingWm=1
            else:
                whites2[whites2.index(pos1)]=pos2
                if piecesWhite[whites2.index(pos2)]=='pawn':
                    lastmove=move+'p'
                    pawnsB[whites2.index(pos2)]=1
                else:
                    lastmove=move
                if pos2[1]=='8' and piecesWhite[whites.index(pos2)]=='pawn':
                    DrawField(Letters,Numbers,blacks,whites)
                    cond=proms[k]
                    piecesWhite[whites.index(pos2)]=cond
                    k+=1
                try:
                    blacks2[blacks2.index(pos2)]='m0'
                except: pass
        else:
            move=prevmoves[i]
            pos1=str(move)[:2]
            pos2=str(move)[2:]
            if pos1==blacks2[15]:
                kingBm=1
            if blacks2.index(pos1) in range(0,8):
                pawnsB[blacks2.index(pos1)]=1
            if pos2 in blacks2:
                if pos1==blacks2[15] and kingBm==0 and pos2 == 'a8' and blacks2.index(pos2) in [8,9]:
                    blacks2[15]='b8'
                    blacks2[blacks2.index('a8')]='c8'
                    kingBm=1
                elif pos1==blacks2[15] and kingBm==0 and pos2=='h8' and blacks2.index(pos2) in [8,9]:
                    blacks2[15]='g8'
                    blacks2[blacks2.index('h8')]='f8'
                    kingBm=1
            else:
                blacks2[blacks2.index(pos1)]=pos2
                if piecesBlack[blacks2.index(pos2)]=='pawn':
                    lastmove=move+'p'
                else:
                    lastmove=move
                if pos2[1]=='1' and piecesBlack[blacks2.index(pos2)]=='pawn':
                    DrawField(Letters,Numbers,blacks,whites)
                    cond=proms[k]
                    piecesBlack[blacks2.index(pos2)]=cond
                    k+=1
                try:
                    whites2[whites2.index(pos2)]='m0'
                except: pass
    return whites2,blacks2,kingWm,kingBm,prevmoves,piecesBlack,piecesWhite,lastmove
def reset():
    clearscreen()
    ht()
    tracer(0)     
tracer(0)

prevmoves=[]
colCorrectMove="#555555"
colwhite="#CEF7E8"
colblack="#25BED6"
colbg="#EBDCA8"
colpiecewhite="#EBEDE6"
colpieceblack="#130226"
piecesBlack=['pawn','pawn','pawn','pawn','pawn','pawn','pawn','pawn','rook','rook','knight','knight','bishop','bishop','queen','king']
piecesWhite=['pawn','pawn','pawn','pawn','pawn','pawn','pawn','pawn','rook','rook','knight','knight','bishop','bishop','queen','king']
piW=['pawn','pawn','pawn','pawn','pawn','pawn','pawn','pawn','rook','rook','knight','knight','bishop','bishop','queen','king']
piB=['pawn','pawn','pawn','pawn','pawn','pawn','pawn','pawn','rook','rook','knight','knight','bishop','bishop','queen','king']
reset()
DrawField(Letters,Numbers,blacks,whites)
i=1
screen=Screen()
screen.setup(width=1.0,height=1.0,startx=0,starty=0)
NumbersR=dict([(x[1],x[0]) for x in Numbers.items()])
LettersR=dict([(x[1],x[0]) for x in Letters.items()])
def Bishop_go(start,end):
    ok=[]
    print(whites,blacks)
    for x in reversed([h for h in Letters.keys()]):
        for y in Numbers.keys():
            if Letters[x]<Letters[start[0]] and Numbers[y]>Numbers[start[1]]:
                if abs(Letters[start[0]] - Letters[x]) == abs(Numbers[start[1]] - Numbers[y]):
                    if x+y in whites or x+y in blacks:
                        break
                    else:
                        ok.append(x+y)
                        
    for x in Letters.keys():
        for y in Numbers.keys():
            if Letters[x]>Letters[start[0]] and Numbers[y]>Numbers[start[1]]:
                if abs(Letters[start[0]] - Letters[x]) == abs(Numbers[start[1]] - Numbers[y]):
                    if x+y in whites or x+y in blacks:
                        print(ok)
                        break
                    else:
                        ok.append(x+y)
                        
    for x in reversed([h for h in Letters.keys()]):
        for y in reversed(Numbers.keys()):
            if Letters[x]<Letters[start[0]] and Numbers[y]<Numbers[start[1]]:
                if abs(Letters[start[0]] - Letters[x]) == abs(Numbers[start[1]] - Numbers[y]):
                    if x+y in whites or x+y in blacks:
                        break
                    else:
                        ok.append(x+y)
                        
    for x in ([h for h in Letters.keys()]):
        for y in reversed(Numbers.keys()):
            if Letters[x]>Letters[start[0]] and Numbers[y]<Numbers[start[1]]:
                if abs(Letters[start[0]] - Letters[x]) == abs(Numbers[start[1]] - Numbers[y]):
                    if x+y in whites or x+y in blacks:
                        break
                    else:
                        ok.append(x+y)
                        
    print(ok)
    return ok
def IsCorrectMove(start, end, piece):
    if start != end and start[0] in Letters and end[0] in Letters and start[1] in Numbers and start[1] in Numbers:
        if start in whites:
            if end in whites:
                return False
            if piecesWhite[piece] =='bishop': #если слон 20.01.2025 14:51
                if abs(Letters[start[0]] - Letters[end[0]]) == abs(Numbers[start[1]] - Numbers[end[1]]):
                    Bishop_go(start,end)
                    return True
            elif piecesWhite[piece] =='rook': #ЕСЛИ ЛАДЬЯ    
                if start[0]==end[0]:
                    for n in range(Numbers[min(end[1],start[1])]+100,Numbers[max(end[1],start[1])],100):
                        ps=start[0]+NumbersR[n]
                        if (ps in whites or ps in blacks):
                            return False
                    return True
                elif start[1]==end[1]:
                    for n in range(Letters[min(end[0],start[0])]+100,Letters[max(end[0],start[0])],100):
                        ps=LettersR[n]+start[1]
                        if (ps in whites or ps in blacks):
                            return False
                    return True
                return False
            elif piecesWhite[piece] =='queen': #ЕСЛИ ФЕРЗЬ
                if end in whites:
                    return False
                if abs(Letters[start[0]] - Letters[end[0]]) == abs(Numbers[start[1]] - Numbers[end[1]]) or start[0]==end[0] or start[1]==end[1]:
                    return True
            elif piecesWhite[piece] =='knight':
                if end in whites:
                    return False
                if (abs(Letters[start[0]] - Letters[end[0]]) == 100 and abs(Numbers[start[1]] - Numbers[end[1]]) == 200) or \
                   (abs(Letters[start[0]] - Letters[end[0]]) == 200 and abs(Numbers[start[1]] - Numbers[end[1]]) == 100):
                    return True
            elif piecesWhite[piece] =='pawn':
                if end in whites:
                    return False
                if start[1]>=end[1]:
                    return False
                if end in blacks:
                    if abs(Letters[start[0]]-Letters[end[0]])==100 and abs(Numbers[start[1]]-Numbers[end[1]])==100:
                        return True
                else:
                    if end[0]==lastmove[0]==lastmove[2] and lastmove[4]=='p' and abs(Numbers[end[1]]-Numbers[lastmove[1]])==100 and abs(Numbers[end[1]]-Numbers[lastmove[3]])==100:
                        try:
                            blacks[blacks.index(lastmove[2:-1])]='m0'
                            return True
                        except: pass
                    else:
                        if pawnsW[piece]==0:
                            if abs(Letters[start[0]]-Letters[end[0]])==0 and abs(Numbers[start[1]]-Numbers[end[1]])<=200:
                                return True
                        else:
                            if abs(Letters[start[0]]-Letters[end[0]])==0 and abs(Numbers[start[1]]-Numbers[end[1]])==100:
                                return True
            else:
                if end not in whites and abs(Letters[start[0]]-Letters[end[0]])<=100 and abs(Numbers[start[1]]-Numbers[end[1]])<=100:
                    return True
        else:
            if end in blacks:
                return False
            if piecesBlack[piece] =='bishop': #если слон 
                if abs(Letters[start[0]] - Letters[end[0]]) == abs(Numbers[start[1]] - Numbers[end[1]]):
                    return True
            elif piecesBlack[piece] =='rook': #ЕСЛИ ЛАДЬЯ
                if start[0]==end[0] or start[1]==end[1]:
                    if start[0]==end[0]:
                        for n in range(Numbers[min(end[1],start[1])]+100,Numbers[max(end[1],start[1])],100):
                            ps=start[0]+NumbersR[n]
                            if (ps in whites or ps in blacks):
                                return False
                        return True
                    elif start[1]==end[1]:
                        for n in range(Letters[min(end[0],start[0])]+100,Letters[max(end[0],start[0])],100):
                            ps=LettersR[n]+start[1]
                            if (ps in whites or ps in blacks):
                                return False
                        return True
            elif piecesBlack[piece] =='queen': #ЕСЛИ ФЕРЗЬ
                if abs(Letters[start[0]] - Letters[end[0]]) == abs(Numbers[start[1]] - Numbers[end[1]]) or start[0]==end[0] or start[1]==end[1]:
                    return True
            elif piecesBlack[piece] =='knight':
                if (abs(Letters[start[0]] - Letters[end[0]]) == 100 and abs(Numbers[start[1]] - Numbers[end[1]]) == 200) or \
                   (abs(Letters[start[0]] - Letters[end[0]]) == 200 and abs(Numbers[start[1]] - Numbers[end[1]]) == 100):
                    return True
            elif piecesBlack[piece] =='pawn':
                if start[1]<=end[1]:
                    return False
                if end in whites:
                    if abs(Letters[start[0]]-Letters[end[0]])==100 and abs(Numbers[start[1]]-Numbers[end[1]])==100:
                        return True
                else:
                    if end[0]==lastmove[0]==lastmove[2] and lastmove[4]=='p' and abs(Numbers[end[1]]-Numbers[lastmove[1]])==100 and abs(Numbers[end[1]]-Numbers[lastmove[3]])==100:
                        whites[whites.index(lastmove[2:-1])]='m0'
                        return True
                    else:
                        if pawnsB[piece]==0:
                            if abs(Letters[start[0]]-Letters[end[0]])==0 and abs(Numbers[start[1]]-Numbers[end[1]])<=200:
                                return True
                        else:
                            if abs(Letters[start[0]]-Letters[end[0]])==0 and abs(Numbers[start[1]]-Numbers[end[1]])==100:
                                return True
            else:
                if abs(Letters[start[0]]-Letters[end[0]])<=100 and abs(Numbers[start[1]]-Numbers[end[1]])<=100:
                    return True
    return False
def AvailableMoves(piece,pieces,piecesColor):
    m=[]
    for lett in Letters.keys():
        for numb in Numbers.keys():
            if IsCorrectMove(piece,str(lett)+str(numb),pieces.index(piece)):
                m.append(lett+numb)
    return m
def CoordsConv(x,y):
    if x<=-300:
        x='a'
    elif x<=-200:
        x='b'
    elif x<=-100:
        x='c'
    elif x<=0:
        x='d'
    elif x<=100:
        x='e'
    elif x<=200:
        x='f'
    elif x<=300:
        x='g'
    elif x<=400:
        x='h'
    if y<=-300:
        y='1'
    elif y<=-200:
        y='2'
    elif y<=-100:
        y='3'
    elif y<=0:
        y='4'
    elif y<=100:
        y='5'
    elif y<=200:
        y='6'
    elif y<=300:
        y='7'
    elif y<=400:
        y='8'
    return x+y
i=0
def funWhite(a,b):
    global i 
    pos1=pos()
    move1=CoordsConv(pos1[0],pos1[1])
    move2=CoordsConv(a,b)
    move=move1+move2
    if 	IsCorrectMove(move1,move2,whites.index(move1)):
        whites[whites.index(move1)]=move2
        i+=1
    try:
        blacks[blacks.index(move2)]='m0'
    except:
        pass
    onscreenclick(MainGame)
    DrawField(Letters, Numbers, blacks, whites)
    return 0
def funBlack(a,b):
    global i
    pos1=pos()
    move1=CoordsConv(pos1[0],pos1[1])
    move2=CoordsConv(a,b)
    move=move1+move2
    if 	IsCorrectMove(move1,move2,blacks.index(move1)):
        blacks[blacks.index(move1)]=move2
        i+=1
    try:
        whites[whites.index(move2)]='m0'
    except:
        pass
    onscreenclick(MainGame)
    DrawField(Letters, Numbers, blacks, whites)
    return 0
def MainGame(x,y):
    global i
    DrawField(Letters, Numbers, blacks, whites)
    move1=CoordsConv(x,y)
    if i%2==0:
        if move1 in whites:
            for point in AvailableMoves(move1,whites,piecesWhite):
                DrawPoint(Letters[point[0]],Numbers[point[1]])
            goto(x,y)
            onscreenclick(funWhite)
    else:
        if move1 in blacks:
            for point in AvailableMoves(move1,blacks,piecesBlack):
                DrawPoint(Letters[point[0]],Numbers[point[1]])
            goto(x,y)
            onscreenclick(funBlack)
onscreenclick(MainGame)
'''while True:
    i += 1
    if i % 2 == 0:   
        try:
            move = int(move)
        except:
            pass
        if move == None:
            break
        if isinstance(move, int) == True:
            whites, blacks, kingWm, kingBm, prevmoves, piecesBlack, piecesWhite, lastmove = reverse(prevmoves, move, white, black)
            i -= move + 1
        else:
            pos1 = str(move)[:2]
            pos2 = str(move)[2:]
            if pos2 in whites and pos1 in whites:
                kw = kingWm
                if pos1 == whites[15] and kingWm == 0 and pos2 == 'a1' and whites.index(pos2) in [8, 9] and 'b1' not in whites and 'c1' not in whites and 'd1' not in whites:
                    whites[15] = 'c1'
                    whites[whites.index('a1')] = 'd1'
                    print('white castle')
                    kingWm = 1
                    prevmoves.append(move)
                elif pos1 == whites[15] and kingWm == 0 and pos2 == 'h1' and whites.index(pos2) in [8, 9] and 'f1' not in whites and 'g1' not in whites:
                    whites[15] = 'g1'
                    whites[whites.index('h1')] = 'f1'
                    print('white castle')
                    kingWm = 1
                    prevmoves.append(move)
                else:
                    i -= 1
                    print('smth is wrong but im tired')
                    print(pos1, whites[15], kingWm, pos2, whites.index(pos2))
                    kingWm = kw
            elif pos2 not in whites and pos1 in whites:
                if (IsCorrectMove(pos1, pos2, whites.index(pos1))):
                    if whites[15] == pos1:
                        kingWm = 1
                    try:
                        prevmoves.append(move)
                        reset()
                        whites[whites.index(pos1)] = pos2
                        if piecesWhite[whites.index(pos2)] == 'pawn':
                            lastmove = move + 'p'
                            pawnsW[whites.index(pos2)]=1
                        else:
                            lastmove = move
                        print(f'{pos1} -> {pos2}')
                        try:
                            blacks[blacks.index(pos2)] = 'm0'
                            print(f'   {pos2} eaten (black)')
                        except:
                            pass
                        if pos2[1] == '8' and piecesWhite[whites.index(pos2)] == 'pawn':
                            DrawField(Letters, Numbers, blacks, whites)
                            cond = textinput('pawn promotion', 'rook/knight/bishop/queen')
                            piecesWhite[whites.index(pos2)] = cond
                            print('white ' + str(pos2[0]).upper() + f'-pawn promoted to {cond}')
                    except:
                        i -= 1
                        print('Nothing here!')
                else:
                    i -= 1
                    print('Incorrect move')
            else:
                print('Theres your piece!')
                i -= 1
    else:
        move = textinput('Black moves', 'type your move,e.g. e2e4')
        move=move.replace(' ','')
        try:
            move = int(move)
        except:
            pass
        if move == None:
            break
        if isinstance(move, int) == True:
            whites, blacks, kingWm, kingBm, prevmoves, piecesBlack, piecesWhite, lastmove = reverse(prevmoves, move, white, black)
            i -= move + 1
        else:
            pos1 = str(move)[:2]
            pos2 = str(move)[2:]
            print(pos1,pos2)
            if pos1 in blacks and pos2 in blacks:
                kb = kingBm
                if pos1 == blacks[15] and kingBm == 0 and pos2 == 'a8' and blacks.index(pos2) in [8, 9] and 'b8' not in blacks and 'c8' not in blacks and 'd8' not in blacks:
                    blacks[15] = 'c8'
                    blacks[blacks.index('a8')] = 'd8'
                    print('black castle')
                    kingBm = 1
                    prevmoves.append(move)
                elif pos1 == blacks[15] and kingBm == 0 and pos2 == 'h8' and blacks.index(pos2) in [8, 9] and 'f8' not in blacks and 'g8' not in blacks:
                    blacks[15] = 'g8'
                    blacks[blacks.index('h8')] = 'f8'
                    print('black castle')
                    kingBm = 1
                    prevmoves.append(move)
                else:
                    i -= 1
                    print('smth is wrong but im tired')
                    kingBm = kb
            elif pos1 in blacks and pos2 not in blacks:
                if (IsCorrectMove(pos1, pos2, blacks.index(pos1))):
                    if blacks[15] == pos1:
                        kingBm = 1
                    try:
                        prevmoves.append(move)
                        reset()
                        blacks[blacks.index(pos1)] = pos2
                        if piecesBlack[blacks.index(pos2)] == 'pawn':
                            lastmove = move + 'p'
                            pawnsB[blacks.index(pos2)]=1
                        else:
                            lastmove = move
                        try:
                            whites[whites.index(pos2)] = 'm0'
                            print(f'        {pos2} eaten (white)')
                        except:
                            pass
                        if pos2[1] == '1' and piecesBlack[blacks.index(pos2)] == 'pawn':
                            DrawField(Letters, Numbers, blacks, whites)
                            cond = textinput('pawn promotion', 'rook/knight/bishop/queen')
                            piecesBlack[blacks.index(pos2)] = cond
                            print('black ' + str(pos2[0]).upper() + f'-pawn promoted to {cond}')
                        print(f'{pos1} -> {pos2}')
                    except:
                        i -= 1
                        print('Nothing here!')
                else:
                    i -= 1
                    print('Incorrect move')
            else:
                print('Theres your piece!')
                i -= 1
    DrawField(Letters, Numbers, blacks, whites)
    for point in AvailableMoves(whites[8],whites,piecesWhite):
        DrawPoint(Letters[point[0]],Numbers[point[1]])
'''
