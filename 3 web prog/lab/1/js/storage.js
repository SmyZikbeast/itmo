const storage = window.localStorage;

export function create(){
    storage.setItem("table", []);
}

export function put(submit){
    let table = storage.getItem("table");
    table.push(submit);
    storage.setItem("table", table);
}

export function get(){
    return storage.getItem("table");
}