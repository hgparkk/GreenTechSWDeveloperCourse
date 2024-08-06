function getTime() {
    let v_now = new Date();
    let v_month = (v_now.getMonth() + 1) + ""
    let v_date = v_now.getDate() + ""
    let v_hours = v_now.getHours() + "";
    let v_minutes = v_now.getMinutes() + "";
    let v_seconds = v_now.getSeconds() + "";

    return v_month.padStart(2, "0") + "." + v_date.padStart(2, "0") + " " + v_hours.padStart(2, "0") + ":" + v_minutes.padStart(2, "0") + ":" + v_seconds.padStart(2, "0") + " "
}