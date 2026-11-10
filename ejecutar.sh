#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
N="${1:?Indica número de caso: 01 a 29}"
N=$(printf "%02d" "$((10#$N))")
java -cp out "psp.ud2.c${N}.Caso${N}"
