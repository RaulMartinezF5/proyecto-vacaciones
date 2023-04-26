export default class CreateRequestPayload {
    issue;
    state;
    startDate;
    endDate;
    nameTypeOfRequest;
    descriptionCauseRequest;
    quantityOfDays;

    constructor(issue,state,startDate,endDate,nameTypeOfRequest,descriptionCauseRequest,quantityOfDays){
        this.issue = issue
        this.state = state
        this.startDate = startDate
        this.endDate = endDate
        this.nameTypeOfRequest = nameTypeOfRequest
        this.descriptionCauseRequest = descriptionCauseRequest
        this.quantityOfDays = quantityOfDays 
    }
}