import {addButton, getCheckbox, getText} from './inputs.js';
const form = document.getElementById('form')
const table = document.getElementById('result-table');

let rows = 0;

let x;
let y;
let r;
const MAX_ROWS = 10;

function addLine(x,y,r){
    const newRow = table.insertRow(1);
    rows++;
    if (rows > MAX_ROWS){
        table.deleteRow(MAX_ROWS + 1);
    }
    newRow.insertCell(0).textContent = rows;
    newRow.insertCell(1).textContent = x;
    newRow.insertCell(2).textContent = y;
    newRow.insertCell(3).textContent = r;
}

export function handleTable(){
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        
        getCheckbox('.r-check', updateR);
        getText('y-text', updateY, -5, 5);
        console.log("x = " + x + " y = " + y + " r = " + r);
        if (x != null && r != null && y != null){
            addLine(x,y,r);
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