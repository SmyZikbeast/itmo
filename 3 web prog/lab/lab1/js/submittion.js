import {check} from './checker.js';

export default class submittion{
    constructor(id, x, y, r){
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = new Date();
        this.result = check(x,y,r);
    }
}