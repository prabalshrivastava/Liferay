
    
    
    ;( function ( document, window, index )
    {
        'use strict';

        var elSelector      = 'header.main-header',
            elClassHidden   = 'header--hidden',
            throttleTimeout = 400,
            element         = document.querySelector( elSelector );

        if( !element ) return true;

        var dHeight         = 0,
            wHeight         = 0,
            wScrollCurrent  = 0,
            wScrollBefore   = 0,
            wScrollDiff     = 0,

            hasElementClass     = function( element, className ){ return element.classList ? element.classList.contains( className ) : new RegExp( '(^| )' + className + '( |$)', 'gi' ).test( element.className ); },
            addElementClass     = function( element, className ){ element.classList ? element.classList.add( className ) : element.className += ' ' + className; },
            removeElementClass  = function( element, className ){ element.classList ? element.classList.remove( className ) : element.className = element.className.replace( new RegExp( '(^|\\b)' + className.split( ' ' ).join( '|' ) + '(\\b|$)', 'gi' ), ' ' ); },

            throttle = function( delay, fn )
            {
                var last, deferTimer;
                return function()
                {
                    var context = this, args = arguments, now = +new Date;
                    if( last && now < last + delay )
                    {
                        clearTimeout( deferTimer );
                        deferTimer = setTimeout( function(){ last = now; fn.apply( context, args ); }, delay );
                    }
                    else
                    {
                        last = now;
                        fn.apply( context, args );
                    }
                };
            };

        window.addEventListener( 'scroll', throttle( throttleTimeout, function()
        {
            dHeight         = document.body.offsetHeight;
            wHeight         = window.innerHeight;
            wScrollCurrent  = window.pageYOffset;
            wScrollDiff     = wScrollBefore - wScrollCurrent;

            if( wScrollCurrent <= 0 ) // scrolled to the very top; element sticks to the top
                removeElementClass( element, elClassHidden );

            else if( wScrollDiff > 0 && hasElementClass( element, elClassHidden ) ) // scrolled up; element slides in
                removeElementClass( element, elClassHidden );

            else if( wScrollDiff < 0 ) // scrolled down
            {
                if( wScrollCurrent + wHeight >= dHeight && hasElementClass( element, elClassHidden ) ) // scrolled to the very bottom; element slides in
                    removeElementClass( element, elClassHidden );

                else // scrolled down; element slides out
                    addElementClass( element, elClassHidden );
            }

            wScrollBefore = wScrollCurrent;
        }));

    }( document, window, 0 ));

    

