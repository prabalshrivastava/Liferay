class SPBase {
    constructor() {
        
    };
    
    debug(msg) {
        if (console && console.log) {
            console.log(msg);
        }
    };        
    
    makeImmutable (obj) {
        if (Object.freeze) Object.freeze(obj);
    };
    
    isObject (obj) {
        return obj === Object(obj);
    };
}
