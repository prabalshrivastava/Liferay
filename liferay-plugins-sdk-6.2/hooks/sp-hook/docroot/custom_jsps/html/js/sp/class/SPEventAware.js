class SPEventAware extends SPBase {
    
    constructor() {
        super();
        this._events = {};
    }

    on (event, listener) {
        if (_.isNil(this._events[event])) {
            this._events[event] = [];
        }
        this._events[event].push(listener);  
        return this;  
    }

    emit (event, ...args) {
        if (_.isNil(this._events[event])) {
            return this;
        }
        _.forEach(this._events[event], (listener) => {
            listener.apply(this.obj, args);
        });
        return this;
    };

    removeListener (event, listener) {
        if (_.isNil(this._events[event])) {
            return this;
        }
        _.pull(this._events[event], listener);
        return this;
    };

    once (event, listener) {
        this.on(event, function handler(...args) {
            removeListener(event, handler);
            listener.apply(this.obj, args);
        });
    };
    
};