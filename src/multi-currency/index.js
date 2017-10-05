export default class Dollar {
  constructor(amount) {
    this.amount = amount
  }

  times(multiplications) {
    return new Dollar(this.amount * multiplications)
  }
}
