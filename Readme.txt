He descargado el SDK de Android de http://developer.android.com/sdk/index.html

Descargo el JDK tambi�n, de http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Creo una cuenta en sandbox.evernote.com

Obtengo la API Key de Evernote (con acceso completo, para poder leer y editar notas)

Descargo la API de https://github.com/evernote/evernote-sdk-android

He iniciado el proyecto vac�o.

A�ado los campos de texto para introducir el usuario y la contrase�a. Tambi�n pongo un bot�n para acceder a Evernote.

Le doy una funcionalidad al bot�n para ver que cuando lo pulso ocurre algo.

Incluyo la API de Evernote dentro del buildpath del proyecto, agregando los .jar de evernote-sdk-android-master\library\libs

El paso anterior no es v�lido. Lo que hago es incluir la librer�a de la API en el build path y en el Java build path.

Modifico el AndroidManifest.xml para incluir los nuevos permisos de Internet, y para incluir la autentiaci�n OAuth de la que 
hace uso Evernote dentro de una Activity.