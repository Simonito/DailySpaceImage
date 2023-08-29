package com.example.dailyspaceimage.repo

import com.example.dailyspaceimage.model.APOD
import java.lang.UnsupportedOperationException
import java.time.LocalDate

interface APODRepository {
    fun getAPOD(date: LocalDate): APOD

    fun getTenAPODsSince(date: LocalDate): List<APOD>

    fun getDefaultAPODs(): List<APOD> {
        return listOf(
            APOD(
                "2023-08-20",
                "What kind of cloud is this?  A type of arcus cloud called a roll cloud.  These rare long clouds may form near advancing cold fronts.   In particular, a downdraft from an advancing storm front can cause moist warm air to rise, cool below its dew point, and so form a cloud.  When this happens uniformly along an extended front, a roll cloud may form.  Roll clouds may actually have air circulating along the long horizontal axis of the cloud.  A roll cloud is not thought to be able to morph into a tornado.  Unlike a similar shelf cloud, a roll cloud is completely detached from their parent  cumulonimbus cloud.  Pictured here, a roll cloud extends far into the distance as a storm approaches in 2007 in Racine, Wisconsin, USA.",
                "https://apod.nasa.gov/apod/image/2308/rollcloud_hanrahan_3072.jpg",
                "https://apod.nasa.gov/apod/image/2308/rollcloud_hanrahan_960.jpg",
                "image",
                "v1",
                "A Roll Cloud Over Wisconsin"
            ),
            APOD(
                "2023-08-21",
                "Will Comet Nishimura become visible to the unaided eye? Given the unpredictability of comets, no one can say for sure, but it currently seems like a good bet.  The comet was discovered only ten days ago by Hideo Nishimura during 30-second exposures with a standard digital camera.  Since then, C/2023 P1 Nishimura has increased in brightness and its path across the inner Solar System determined.  As the comet dives toward the Sun, it will surely continue to intensify and possibly become a naked-eye object in early September.  A problem is that the comet will also be angularly near the Sun, so it will only be possible to see it near sunset or sunrise.  The comet will get so close to the Sun -- inside the orbit of planet Mercury -- that its nucleus may break up. Pictured, Comet Nishimura was imaged three days ago from June Lake, California, USA while sporting a green coma and a thin tail.",
                "https://apod.nasa.gov/apod/image/2308/CometNishimura_Bartlett_2062.jpg",
                "https://apod.nasa.gov/apod/image/2308/CometNishimura_Bartlett_1080.jpg",
                "image",
                "v1",
                "Introducing Comet Nishimura"
            ),
            APOD(
                "2023-08-22",
                "This nebula had never been noted before. Newly discovered nebulas are usually angularly small and found by professionals using large telescopes. In contrast, the Pistachio Nebula was discovered by dedicated amateurs and, although faint, is nearly the size of the full Moon.  In modern times, amateurs with even small telescopes can create long exposures over sky areas much larger than most professional telescopes can see.  They can therefore discover both previously unknown areas of extended emission around known objects, as well as entirely unknown objects, like nebulas.  The pictured Pistachio Nebula is shown in oxygen emission (blue) and hydrogen emission (red).  The nature of the hot central star is currently unknown, and the nebula might be labeled a planetary nebula if it turns out to be a white dwarf star.  The featured image is a composite of over 70 hours of exposure taken in early June under the dark skies of Namibia.",
                "https://apod.nasa.gov/apod/image/2308/Pistachio_Falls_2952.jpg",
                "https://apod.nasa.gov/apod/image/2308/Pistachio_Falls_960.jpg",
                "image",
                "v1",
                "The Pistachio Nebula"
            ),
            APOD(
                "2023-08-23",
                "It came from outer space. It -- in this case a sand-sized bit of a comet nucleus -- was likely ejected many years ago from Sun-orbiting Comet Swift-Tuttle, but then continued to orbit the Sun alone.  When the Earth crossed through this orbit, the piece of comet debris impacted the atmosphere of our fair planet and was seen as a meteor. This meteor deteriorated, causing gases to be emitted that glowed in colors emitted by its component elements. The featured image was taken last week from Castilla La Mancha, Spain, during the peak night of the Perseids meteor shower.  The picturesque meteor streak happened to appear in the only one of 50 frames that also included the Andromeda galaxy. Stars dot the frame, each much further away than the meteor. Compared to the stars, the Andromeda galaxy (M31) is, again, much further away.",
                "https://apod.nasa.gov/apod/image/2308/M31Perseid_Pedrero_3232.jpg",
                "https://apod.nasa.gov/apod/image/2308/M31Perseid_Pedrero_1080.jpg",
                "image",
                "v1",
                "The Meteor and the Galaxy"
            ),
            APOD(
                "2023-08-24",
                "Under dark and mostly moonless night skies, many denizens of planet Earth were able to watch this year's Perseid meteor shower. Seen from a grassy hillside from Shiraz, Iran these Perseid meteors streak along the northern summer Milky Way before dawn on Sunday, August 13. Frames used to construct the composited image were captured near the active annual meteor shower's peak between 02:00 AM and 04:30 AM local time. Not in this night skyscape, the shower's radiant in the heroic constellation Perseus is far above the camera's field of view. But fans of northern summer nights can still spot a familiar asterism. Formed by bright stars Deneb, Vega, and Altair, the Summer Triangle spans the luminous band of the Milky Way.",
                "https://apod.nasa.gov/apod/image/2308/MSH21080.jpg",
                "https://apod.nasa.gov/apod/image/2308/MSH11080.jpg",
                "image",
                "v1",
                "Meteors along the Milky Way"
            )
        )
    }
}

class TestingAPODRepo : APODRepository {
    private val message = "Operation not supported this interface is only for" +
        "testing. Use `getDefaultAPODs` method only!"

    override fun getAPOD(date: LocalDate): APOD {
        throw UnsupportedOperationException(message)
    }

    override fun getTenAPODsSince(date: LocalDate): List<APOD> {
        throw UnsupportedOperationException(message)
    }
}