function bl(x,y,r){
    return (x <= 0 && y <= 0 && x >= -r/2 && y >= -r);
}

function br(x,y,r){
    return (x >= 0 && y <= 0 && y >= x - r);
}

function tr(x,y,r){
    return false;
}

function tl(x,y,r){
    return (x <= 0 && y >= 0 && x^2 + y^2 <= r^2);
}

export function check(x, y, r){
    if (bl(x,y,r) || br(x,y,r) || tr(x,y,r) || tl(x,y,r)){
        return 'hit';
    }
    return 'miss';
}