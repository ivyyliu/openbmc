SUMMARY = "YAML configuration for Runbmc Nuvoton"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${QUANTABASE}/COPYING.apache-2.0;md5=34400b68072d710fecd0a2940a0d1658"

inherit allarch

SRC_URI = " \
    file://runbmc-nuvoton-ipmi-fru.yaml \
    file://runbmc-nuvoton-ipmi-fru-bmc.yaml \
    file://runbmc-nuvoton-ipmi-fru-properties.yaml \
    file://runbmc-nuvoton-ipmi-inventory-sensors.yaml \
    file://runbmc-nuvoton-ipmi-sensors.yaml \
    "

S = "${WORKDIR}"

do_install() {
    cat runbmc-nuvoton-ipmi-fru.yaml runbmc-nuvoton-ipmi-fru-bmc.yaml > fru-read.yaml

    install -m 0644 -D runbmc-nuvoton-ipmi-fru-properties.yaml \
        ${D}${datadir}/${BPN}/ipmi-extra-properties.yaml
    install -m 0644 -D fru-read.yaml \
        ${D}${datadir}/${BPN}/ipmi-fru-read.yaml
    install -m 0644 -D runbmc-nuvoton-ipmi-inventory-sensors.yaml \
        ${D}${datadir}/${BPN}/ipmi-inventory-sensors.yaml
    install -m 0644 -D runbmc-nuvoton-ipmi-sensors.yaml \
        ${D}${datadir}/${BPN}/ipmi-sensors.yaml
}

FILES_${PN}-dev = " \
    ${datadir}/${BPN}/ipmi-extra-properties.yaml \
    ${datadir}/${BPN}/ipmi-fru-read.yaml \
    ${datadir}/${BPN}/ipmi-inventory-sensors.yaml \
    ${datadir}/${BPN}/ipmi-sensors.yaml \
    "

ALLOW_EMPTY_${PN} = "1"
