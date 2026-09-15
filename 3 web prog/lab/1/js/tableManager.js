import {addButton, getCheckbox, getText} from './inputs.js';
import {put, get, create} from './storage.js';
import submittion from './submittion.js';
const form = document.getElementById('form')
const table = document.getElementById('result-table');

const MAX_ROWS = 10;
let rows = 0;

let x;
let y;
let r;

function addNewLine(x,y,r){
    let submit = new submittion(rows, x, y, r);
    put(submit);
    addLine(submit);
}

function addLine(submit){
    const newRow = table.insertRow(1);
    rows++;
    if (rows > MAX_ROWS){
        table.deleteRow(MAX_ROWS + 1);
    }
    let time = submit.time;
    newRow.insertCell(0).textContent = submit.id;
    newRow.insertCell(1).textContent = submit.x;
    newRow.insertCell(2).textContent = submit.y;
    newRow.insertCell(3).textContent = submit.r;
    newRow.insertCell(4).textContent = time.getHours()+':'+time.getMinutes()+':'+time.getSeconds();
    newRow.insertCell(5).textContent = submit.result;
}

export function handleTable(){
    create();
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        getCheckbox('.r-check', updateR);
        getText('y-text', updateY, -5, 5);
        console.log("x = " + x + " y = " + y + " r = " + r);
        if (x != null && r != null && y != null){
            addNewLine(x,y,r);
        }
    }
    )
}

function updateX(value){
    x = value;
}

function updateY(value){
    y = value;
}

function updateR(value){
    r = value;
}

addButton('.x-button', updateX);