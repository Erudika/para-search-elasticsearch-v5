FROM openjdk:8-jdk-alpine

WORKDIR /para

ENV PARA_PLUGIN_ID="para-search-elasticsearch-v5" \
	PARA_PLUGIN_VER="1.29.1"

RUN wget -q -P /para/lib/ https://oss.sonatype.org/service/local/repositories/releases/content/com/erudika/$PARA_PLUGIN_ID/$PARA_PLUGIN_VER/$PARA_PLUGIN_ID-$PARA_PLUGIN_VER-shaded.jar \
	|| exit 2