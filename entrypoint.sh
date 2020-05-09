#!/bin/bash

cmd='java '

if [[ -n ${DEBUG} ]]; then
    cmd=${cmd}'
        -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=9999
    '
fi

cmd=${cmd}'
            -jar app.jar $@
'

echo ${cmd}
eval ${cmd}


