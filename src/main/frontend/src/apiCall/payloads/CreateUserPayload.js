export default class CreateUserPayload{
    document
    name
    lastName
    email
    password
    holyDays
    position
    userType
    location
    singInDate
    widthdrawalDate

    constructor (document, name, lastName, email, password, holyDays, position,
                 userType, location, singInDate, widthdrawalDate){
                    this.document = document
                    this.name = name
                    this.lastName = lastName
                    this.email = email
                    this.password = password
                    this.holyDays = holyDays
                    this.position = position
                    this.userType = userType
                    this.location = location
                    this.singInDate = singInDate
                    this.widthdrawalDate = widthdrawalDate
                 }
}