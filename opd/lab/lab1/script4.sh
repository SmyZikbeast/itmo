wc -l lab01/shelmet2 >> lab01/shelmet02;
ls -liR lab01 | grep '^m' | sort -k1,1n | head -n 3;
ls  2> /dev/null -R lab01 | grep '2$' | sort -d;
ls 2> /dev/null -ltR lab01 | grep -E 'do' | sort -k6,6 | head -n 4;
ls -lrR lab01 | grep 'k$' | sort -d;
ls -ltR lab01 | grep ' m' | sort -k6,6 | head -n 4;