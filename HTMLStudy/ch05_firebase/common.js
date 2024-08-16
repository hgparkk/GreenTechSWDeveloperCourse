function makeUniqueId() {
    let date = new Date()

    let v_year = date.getFullYear() + ""
    let v_month = ((date.getMonth() + 1) + "").padStart(2, "0")
    let v_date = (date.getDate() + "").padStart(2, "0")
    let v_hours = (date.getHours() + "").padStart(2, "0")
    let v_minutes = (date.getMinutes() + "").padStart(2, "0")
    let v_seconds = (date.getSeconds() + "").padStart(2, "0")
    let v_milliseconds = (date.getMilliseconds() + "").padStart(3, "0")

    let v_uniqueId = v_year + v_month + v_date + v_hours + v_minutes + v_seconds + v_milliseconds

    for (let i = 0; i < 6; i++) {
        v_uniqueId += (Math.floor(Math.random() * 10) + "")
    }

    return v_uniqueId
}

function makeBoardDate() {
    let date = new Date()

    let v_month = ((date.getMonth() + 1) + "").padStart(2, "0")
    let v_date = (date.getDate() + "").padStart(2, "0")
    let v_hours = (date.getHours() + "").padStart(2, "0")
    let v_minutes = (date.getMinutes() + "").padStart(2, "0")

    return v_month + "-" + v_date + " " + v_hours + ":" + v_minutes
}